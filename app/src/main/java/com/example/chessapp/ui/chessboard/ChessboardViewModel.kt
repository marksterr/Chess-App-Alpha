package com.example.chessapp.ui.chessboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chessapp.data.models.Piece
import com.example.chessapp.data.models.PieceColor
import com.example.chessapp.data.models.PieceType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChessboardViewModel @Inject constructor() : ViewModel() {
    private val _chessboard: MutableLiveData<List<List<Piece>>> = MutableLiveData()
    val chessboard: LiveData<List<List<Piece>>> get() = _chessboard

    init {
        setupBoard()
    }

    private fun setupBoard() {
        val board = List(8) { MutableList(8) { Piece(PieceType.EMPTY, PieceColor.WHITE) } }

        // Place black pieces
        for (i in 0 until 8) {
            board[1][i] = Piece(PieceType.PAWN, PieceColor.BLACK)
        }
        board[0][0] = Piece(PieceType.ROOK, PieceColor.BLACK)
        board[0][1] = Piece(PieceType.KNIGHT, PieceColor.BLACK)
        board[0][2] = Piece(PieceType.BISHOP, PieceColor.BLACK)
        board[0][3] = Piece(PieceType.QUEEN, PieceColor.BLACK)
        board[0][4] = Piece(PieceType.KING, PieceColor.BLACK)
        board[0][5] = Piece(PieceType.BISHOP, PieceColor.BLACK)
        board[0][6] = Piece(PieceType.KNIGHT, PieceColor.BLACK)
        board[0][7] = Piece(PieceType.ROOK, PieceColor.BLACK)

        // Place white pieces
        for (i in 0 until 8) {
            board[6][i] = Piece(PieceType.PAWN, PieceColor.WHITE)
        }
        board[7][0] = Piece(PieceType.ROOK, PieceColor.WHITE)
        board[7][1] = Piece(PieceType.KNIGHT, PieceColor.WHITE)
        board[7][2] = Piece(PieceType.BISHOP, PieceColor.WHITE)
        board[7][3] = Piece(PieceType.QUEEN, PieceColor.WHITE)
        board[7][4] = Piece(PieceType.KING, PieceColor.WHITE)
        board[7][5] = Piece(PieceType.BISHOP, PieceColor.WHITE)
        board[7][6] = Piece(PieceType.KNIGHT, PieceColor.WHITE)
        board[7][7] = Piece(PieceType.ROOK, PieceColor.WHITE)

        // Set the value of the chessboard LiveData
        _chessboard.value = board
    }
}