class Effect {
    static void horizontalFlip(int[][] image) {
        int temp = 0;
        for (int y = 0; y < image.length; y++)
            for (int x = 0; x < image[y].length / 2; x++) {
                temp = image[y][x];
                image[y][x] = image[y][image[y].length - x - 1];
                image[y][image[y].length - x - 1] = temp;
            }
    }

    static void verticalFlip(int[][] image) {
        int temp = 0;
        for (int x = 0; x < image[0].length; x++)
           for (int y = 0; y < image.length / 2; y++) {
               temp = image[y][x];
               image[y][x] = image[image.length - y - 1][x];
               image[image.length - y - 1][x] = temp;
           }
    }

    static void margin(int[][] image) {
        int BORDER = 30;
        for (int x = 0; x < BORDER; x++)
            for (int y = 0; y < image[x].length; y++) {
                image[x][y] = 255;
                image[image.length - x - 1][y] = 255;
            }

        for (int x = BORDER; x < image.length - BORDER; x++)
            for (int y = 0; y < BORDER; y++) {
                image[x][y] = 255;
                image[x][image[x].length - y - 1] = 255;
            }
    }

    static void vignette(int[][] image, int intensity) {
        double maxDistance = Math.sqrt(Math.pow((0 - (double) image.length / 2), 2) + Math.pow((0 - (double) image[0].length / 2), 2));
        for (int x = 0; x < image.length; x++)
            for (int y = 0; y < image[x].length; y++) {
                double distance = Math.sqrt(Math.pow((x - (double) image.length / 2), 2) + Math.pow((y - (double) image[x].length / 2), 2));
                double fator = 1 - ((distance / maxDistance) * ((double) intensity / 100));
                image[x][y] *= fator;
            }
    }

    static void blur(int[][] image, int ray) {
        int[][] newImg = new int[image.length][image[0].length];
        int sum = 0;
        int count = 0;

        for (int i = 0; i < image.length; i++)
            for (int j = 0; j < image[0].length; j++) {
                // view each pos
                sum = 0;
                count = 0;
                for (int lines = i - ray; lines <= i + ray; lines++) {
                    for (int cols = j - ray; cols <= j + ray; cols++) {
                        if (lines >= 0 && lines < image.length && cols >= 0 && cols < image[i].length) {
                            sum += image[lines][cols];
                            count++;
                        }
                    }
                }
                newImg[i][j] = sum / count;
            }

        for (int i = 0; i < image.length; i++)
            for (int j = 0; j < image[0].length; j++)
                image[i][j] = newImg[i][j];
    }
}
