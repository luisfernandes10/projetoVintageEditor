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
}
