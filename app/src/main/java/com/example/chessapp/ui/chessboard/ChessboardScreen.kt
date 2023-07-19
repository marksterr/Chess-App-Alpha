package com.example.chessapp.ui.chessboard

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.chessapp.data.models.Piece
import com.example.chessapp.data.models.PieceColor
import com.example.chessapp.data.models.PieceType
import com.example.chessapp.ui.theme.DarkSquare
import com.example.chessapp.ui.theme.LightSquare

@Composable
fun Chessboard(chessboard: List<List<Piece>>, context: Context) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        chessboard.forEachIndexed { rowIndex, row ->
            Row {
                row.forEachIndexed { colIndex, piece ->
                    Box(
                        modifier = Modifier
                            .size(45.dp)  // Square size
                            .background(if ((rowIndex + colIndex) % 2 == 0) LightSquare else DarkSquare)
                    ) {
                        if (piece.type != PieceType.EMPTY) {
                            val piecePainter = getPiecePainter(piece, context)
                            Image(
                                painter = piecePainter,
                                contentDescription = "Chess Piece",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun getPiecePainter(piece: Piece, context: Context): Painter {
    val resourceName = when (piece.type) {
        PieceType.PAWN -> if (piece.color == PieceColor.WHITE) "white_pawn" else "black_pawn"
        PieceType.ROOK -> if (piece.color == PieceColor.WHITE) "white_rook" else "black_rook"
        PieceType.KNIGHT -> if (piece.color == PieceColor.WHITE) "white_knight" else "black_knight"
        PieceType.BISHOP -> if (piece.color == PieceColor.WHITE) "white_bishop" else "black_bishop"
        PieceType.QUEEN -> if (piece.color == PieceColor.WHITE) "white_queen" else "black_queen"
        PieceType.KING -> if (piece.color == PieceColor.WHITE) "white_king" else "black_king"
        else -> null
    }
    val resourceId = resourceName?.let {
        context.resources.getIdentifier(it, "drawable", context.packageName)
    } ?: 0

    return painterResource(resourceId)
}