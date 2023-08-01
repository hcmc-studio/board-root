package studio.hcmc.board.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import studio.hcmc.board.dto.ArticleDTO
import studio.hcmc.board.dto.ErrorDTO
import studio.hcmc.board.entity.ArticleEntity
import studio.hcmc.board.repository.ArticleRepository
import studio.hcmc.board.vo.ArticleVO
import studio.hcmc.kotlin.protocol.SortOrder
import studio.hcmc.protocol.PageRequest
import studio.hcmc.protocol.toSortDirection

@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {
    @Transactional
    fun add(boardId: Long, writerAddress: String, dto: ArticleDTO.Post): ArticleVO {
        return articleRepository
            .save(ArticleEntity().apply {
                fromDataTransferObject(dto)
                this.boardId = boardId
                this.writerAddress = writerAddress
            })
            .toValueObject()
    }

    @Transactional
    fun set(id: Long, dto: ArticleDTO.Put): ArticleVO {
        return getEntity(id)
            .apply { if (writerPassword != dto.writerPassword) throw ErrorDTO.ArticlePasswordMismatch }
            .apply { fromDataTransferObject(dto) }
            .toValueObject()
    }

    @Transactional
    fun remove(id: Long) {
        articleRepository.deleteById(id)
    }

    @Transactional
    fun get(id: Long): ArticleVO {
        return getEntity(id).toValueObject()
    }

    @Transactional
    fun listAll(offset: Long, size: Int, sortOrder: SortOrder): List<ArticleVO> {
        return articleRepository.findAll(PageRequest(offset, size, sortOrder.toSortDirection(), "id"))
            .content
            .map(ArticleEntity::toValueObject)
    }

    @Transactional
    fun listByBoardId(boardId: Long, offset: Long, size: Int, sortOrder: SortOrder): List<ArticleVO> {
        return articleRepository.findAllByBoardId(boardId, PageRequest(offset, size, sortOrder.toSortDirection(), "id"))
            .content
            .map(ArticleEntity::toValueObject)
    }

    @Transactional
    fun countByBoardId(boardId: Long): Long {
        return articleRepository.countAllByBoardId(boardId)
    }

    @Transactional
    internal fun getEntity(id: Long): ArticleEntity {
        return articleRepository
            .findById(id)
            .orElseThrow { ErrorDTO.ArticleNotFound }
    }
}