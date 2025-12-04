import pt.iscte.greyditor.Editor;
import pt.iscte.greyditor.Selection;

class Operations {
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

    static int[][] darkenArea(int[][] image, Editor editor) {
        Selection selection = editor.getSelection();
        if (selection == null) {
            editor.message("Please select an area of the image.");
        }
        else {
            int factor = editor.getInteger("Intensity?");
            for (int y = selection.y(); y < selection.y() + selection.height(); y++)
                for (int x = selection.x(); x < selection.x() + selection.width(); x++)
                    image[y][x] = Math.max(0, image[y][x] - factor);
        }
        return null;
    }
}