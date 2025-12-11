import pt.iscte.greyditor.Editor;
import pt.iscte.greyditor.Selection;

class Operations {
    static Memory memory = new Memory();

    static int[][] crop(int[][] image, Editor editor) {
        Selection selection = editor.getSelection();
        int[][] newImg;
        if (selection == null) {
            editor.message("Please select an area of the image.");
        }
        else {
            newImg = new int[selection.height()][selection.width()];
            for (int y = selection.y(); y < selection.y() + selection.height(); y++)
                for (int x = selection.x(); x < selection.x() + selection.width(); x++)
                    newImg[y - selection.y()][x - selection.x()] = image[y][x];
            return newImg;
        }
        return image;
    }

    static int[][] expand(int[][] image, Editor editor) {
        int[][] newImg;
        int height = editor.getInteger("Height? ");
        int width = editor.getInteger("Width? ");

        if (height <= 0 || width <= 0)
            editor.message("Please give a valid integer");
        else {
            newImg = new int[height][width];
            for (int y = 0; y < image.length; y++)
                for (int x = 0; x < image[y].length; x++)
                    newImg[y][x] = image[y][x];
            return newImg;
        }
        return image;
    }

    static int[][] rotate(int[][] image) {
        int[][] newImg = new int[image[0].length][image.length];

        for (int i = 0; i < image.length; i++)
            for (int j = 0; j < image[0].length; j++) {
                newImg[j][image.length - i - 1] = image[i][j];
            }
        return newImg;
    }

    static int[][] old(int[][] image) {
        for (int i = 0; i < image.length; i++)
            for (int j = 0; j < image[i].length; j++)
                image[i][j] = Filters.grain(image[i][j], 80);
        Effect.vignette(image, 100);
        Effect.margin(image);
        return image;
    }

    static int[][] retro(int[][] image) {
        for (int i = 0; i < image.length; i++)
            for (int j = 0; j < image[i].length; j++)
                image[i][j] = Filters.contrast(image[i][j], 80);
        Effect.blur(image, 1);
        Effect.vignette(image, 100);

        return image;
    }

    static int[][] copy(int[][] image, Editor editor) {
        memory.copy(image, editor);
        return null;
    }

    static int[][] cut(int[][] image, Editor editor) {
        memory.cut(image, editor);
        return null;
    }

    static int[][] paste(int[][] image, Editor editor) {
        memory.paste(image, editor);
        return image;
    }

    static int[][] undo(int[][] image, Editor editor) {
        return memory.undo(image,editor);
    }
}