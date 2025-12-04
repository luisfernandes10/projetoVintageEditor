class Filters {
    static int brightness(int tone, int intensity) {
        if (tone - intensity < 0)
            return 0;
        else
            return Math.min(tone - intensity, 255);
    }

    static int contrast(int tone, int intensity) {
        if (tone > 127)
            return Math.min(tone + intensity, 255);
        else
            return Math.max(tone - intensity, 0);
    }

    static int grain(int tone, int intensity) {
        int r = (int) (Math.random() * intensity);

        if (tone - r < 0)
            return 0;
        else
            return Math.min(tone - r, 255);
    }
}
