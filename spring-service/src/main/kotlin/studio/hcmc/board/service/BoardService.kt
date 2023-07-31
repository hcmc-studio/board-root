package studio.hcmc.board.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import studio.hcmc.board.dto.BoardDTO
import studio.hcmc.board.dto.ErrorDTO
import studio.hcmc.board.entity.BoardEntity
import studio.hcmc.board.repository.BoardRepository
import studio.hcmc.board.vo.BoardVO
import studio.hcmc.kotlin.protocol.SortOrder
import studio.hcmc.protocol.PageRequest
import studio.hcmc.protocol.toSortDirection

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {
    @Transactional
    fun add(dto: BoardDTO.Post): BoardVO {
        return boardRepository
            .save(BoardEntity().apply { fromDataTransferObject(dto) })
            .toValueObject()
    }

    @Transactional
    fun set(id: Long, dto: BoardDTO.Put): BoardVO {
        return getEntity(id)
            .apply { fromDataTransferObject(dto) }
            .toValueObject()
    }

    @Transactional
    fun remove(id: Long) {
        boardRepository.deleteById(id)
    }

    @Transactional
    fun get(id: Long): BoardVO {
        return getEntity(id).toValueObject()
    }

    @Transactional
    fun listAll(offset: Long, size: Int, sortOrder: SortOrder): List<BoardVO> {
        return boardRepository.findAll(PageRequest(offset, size, sortOrder.toSortDirection(), "id"))
            .content
            .map(BoardEntity::toValueObject)
    }

    @Transactional
    fun countAll(): Long {
        return boardRepository.count()
    }

    @Transactional
    internal fun getEntity(id: Long): BoardEntity {
        return boardRepository
            .findById(id)
            .orElseThrow { ErrorDTO.BoardNotFound }
    }
}