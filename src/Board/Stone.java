package Board;

public enum Stone {
    BLANK,
    BLACK,
    WHITE;

    public Stone opposite() {
        if (this == BLACK) return WHITE;
        if (this == WHITE) return BLACK;
        return BLANK;
    }
}
