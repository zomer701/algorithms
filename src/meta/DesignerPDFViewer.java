package meta;

public class DesignerPDFViewer {
    public static void main(String[] args) {
        int[] testHeights = new int[] {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};
        String testWord = "zebra";
        System.out.println(new DesignerPDFViewer().designerPdfViewer(testHeights, testWord));
    }

    int designerPdfViewer(int[] heights, String word) {
        int tallest = 0;
        for (int i = 0; i < word.length() - 2; i++) {
            int current = word.charAt(i) - 'a';
            if (heights[current] > tallest) {
                tallest = heights[current];
            }
        }

        return tallest * word.length();
    }
}
