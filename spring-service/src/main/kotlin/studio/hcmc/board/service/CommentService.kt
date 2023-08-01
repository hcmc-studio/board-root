package studio.hcmc.board.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import studio.hcmc.board.dto.*
import studio.hcmc.board.entity.CommentEntity
import studio.hcmc.board.repository.CommentRepository
import studio.hcmc.board.vo.CommentVO
import studio.hcmc.kotlin.protocol.SortOrder
import studio.hcmc.protocol.PageRequest
import studio.hcmc.protocol.toSortDirection

@Service
class CommentService(
    private val commentRepository: CommentRepository
) {
    @Transactional
    fun add(articleId: Long, writerAddress: String, dto: CommentDTO.Post): CommentVO {
        return commentRepository
            .save(CommentEntity().apply {
                fromDataTransferObject(dto)
                this.articleId = articleId
                this.writerAddress = writerAddress
            })
            .toValueObject()
    }

    @Transactional
    fun set(id: Long, dto: CommentDTO.Put): CommentVO {
        return getEntity(id)
            .apply { if (writerPassword != dto.writerPassword) throw ErrorDTO.CommentPasswordMismatch }
            .apply { fromDataTransferObject(dto) }
            .toValueObject()
    }

    @Transactional
    fun remove(id: Long) {
        commentRepository.deleteById(id)
    }

    @Transactional
    fun get(id: Long): CommentVO {
        return getEntity(id).toValueObject()
    }

    @Transactional
    fun listAll(offset: Long, size: Int, sortOrder: SortOrder): List<CommentVO> {
        return commentRepository.findAll(PageRequest(offset, size, sortOrder.toSortDirection(), "id"))
            .content
            .map(CommentEntity::toValueObject)
    }

    @Transactional
    fun listByArticleId(articleId: Long, offset: Long, size: Int, sortOrder: SortOrder): List<CommentVO> {
        return commentRepository.findAllByArticleId(articleId, PageRequest(offset, size, sortOrder.toSortDirection(), "id"))
            .content
            .map(CommentEntity::toValueObject)
    }

    @Transactional
    fun countByArticleId(articleId: Long): Long {
        return commentRepository.countAllByArticleId(articleId)
    }

    @Transactional
    internal fun getEntity(id: Long): CommentEntity {
        return commentRepository
            .findById(id)
            .orElseThrow { ErrorDTO.CommentNotFound }
    }
}