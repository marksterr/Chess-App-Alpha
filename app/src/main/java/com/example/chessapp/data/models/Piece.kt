package com.example.chessapp.data.models

enum class PieceType {
    EMPTY, PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
}

enum class PieceColor {
    WHITE, BLACK
}

data class Piece(val type: PieceType, val color: PieceColor)