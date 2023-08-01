package studio.hcmc.board.dto

import org.springframework.http.HttpStatus

val ErrorDTO.BoardNotFound.status: HttpStatus get() = HttpStatus.NOT_FOUND
val ErrorDTO.ArticleNotFound.status: HttpStatus get() = HttpStatus.NOT_FOUND
val ErrorDTO.ArticlePasswordMismatch.status: HttpStatus get() = HttpStatus.FORBIDDEN
val ErrorDTO.CommentNotFound.status: HttpStatus get() = HttpStatus.NOT_FOUND
val ErrorDTO.CommentPasswordMismatch.status: HttpStatus get() = HttpStatus.FORBIDDEN