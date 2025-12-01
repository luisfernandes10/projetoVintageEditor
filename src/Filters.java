class Filters {
    static int brightness(int tone, int intensity) {
        if (tone - intensity < 0)
            return 0;
        else
            return Math.min(tone - intensity, 255);
    }

    static int invert(int tone) {
        return 255 - tone;
    }

    static int grain(int tone) {
        return (int) Math.max(tone + (Math.random() * 255), 255);
    }
}
