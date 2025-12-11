import pt.iscte.greyditor.Editor;
import pt.iscte.greyditor.Selection;

class Memory {
    int[][] clipboard;
    int[][][] history = new int[5][][];
    boolean cut = false;
    int iter = 0;
    int count = 0;

    void copy(int[][] image, Editor editor) {
        cut = false;
        toClipboard(image, editor);
    }

    void cut(int[][] image, Editor editor) {
        cut = true;
        toClipboard(image, editor);
    }

    void toClipboard(int[][] image, Editor editor) {
        Selection selection = editor.getSelection();

        if (selection == null)
            editor.message("Please select an area of the image.");
        else {
            clipboard = new int[selection.height()][selection.width()];

            for (int y = selection.y(); y < selection.y() + selection.height(); y++)
                for (int x = selection.x(); x < selection.x() + selection.width(); x++) {
                    clipboard[y - selection.y()][x - selection.x()] = image[y][x];
                    if (cut)
                        image[y][x] = 255;
                }
        }
    }

    void paste(int[][] image, Editor editor) {
        Selection selection = editor.getSelection();
        if (selection == null)
            editor.message("Please select an area of the image.");
        else if (clipboard == null)
            editor.message("Clipboard empty");
        else {
            saveCurrent(image);
            for (int y = 0; y < clipboard.length; y++)
                for (int x = 0; x < clipboard[0].length; x++) {
                    int imageY = selection.y() + y;
                    int imageX = selection.x() + x;

                    if (imageY < image.length && imageX < image[0].length)
                        image[imageY][imageX] = clipboard[y][x];
                }
        }
        if (cut)
            clipboard = null;
    }

    void saveCurrent(int[][] image) {
        history[iter % 5] = new int[image.length][image[0].length];

        for (int i = 0; i < image.length; i++)
            for (int j = 0; j < image[0].length; j++)
                history[iter % 5][i][j] = image[i][j];
        iter = (iter + 1) % 5;
        if (count < 5)
            count++;
    }

    int[][] undo(int[][] image, Editor editor) {
        if (count == 0)
            editor.message("No more images on memory");
        else {
            iter = (iter - 1 + 5) % 5;
            for (int i = 0; i < image.length; i++)
                for (int j = 0; j < image[0].length; j++)
                    image[i][j] = history[iter][i][j];
            if (count > 0)
                count--;
        }
        return image;
    }
}
