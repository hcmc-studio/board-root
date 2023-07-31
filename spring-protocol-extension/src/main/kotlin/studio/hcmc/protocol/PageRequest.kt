package studio.hcmc.protocol

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction
import studio.hcmc.kotlin.protocol.SortOrder

fun PageRequest(offset: Long, size: Int): PageRequest {
    return PageRequest.of(page(offset, size), size)
}

fun PageRequest(offset: Long, size: Int, sort: Sort): PageRequest {
    return PageRequest.of(page(offset, size), size, sort)
}

fun PageRequest(offset: Long, size: Int, direction: Direction, vararg properties: String): PageRequest {
    return PageRequest.of(page(offset, size), size, direction, *properties)
}

private fun page(offset: Long, size: Int): Int {
    if (offset !in Int.MIN_VALUE.toLong()..Int.MAX_VALUE.toLong()) {
        throw IllegalArgumentException("offset overflow: $offset")
    }

    return offset.toInt() / size
}