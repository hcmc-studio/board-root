package studio.hcmc.protocol

import org.springframework.data.domain.Sort
import studio.hcmc.kotlin.protocol.SortOrder

fun SortOrder.toSortDirection(): Sort.Direction {
    return when (this) {
        SortOrder.ASC -> Sort.Direction.ASC
        SortOrder.DESC -> Sort.Direction.DESC
        else -> throw UnsupportedOperationException(name)
    }
}