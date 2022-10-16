package Board;

public enum Color {
    BLANK,
    BLACK,
    WHITE;

    public Color opposite() {
        if (this == BLACK) return WHITE;
        if (this == WHITE) return BLACK;
        return BLANK;
    }
}
