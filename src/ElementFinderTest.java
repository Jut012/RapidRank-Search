import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;

public class ElementFinderTest {

    private void createTestFile(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }

    @Test
    public void testKthLargestSimple() throws IOException {
        createTestFile("test1.txt", "1 4 6 8 9\n10 13 14 0 1\n98 96 5 3 2\n");
        assertEquals(13, ElementFinder.Kth_finder("test1.txt", 4, "largest"));
    }

    // @Test
    // public void testKthSmallestSimple() throws IOException {
    //     createTestFile("test2.txt", "1 4 6 8 9\n10 13 14 0 1\n98 96 5 3 2\n");
    //     assertEquals(4, ElementFinder.Kth_finder("test2.txt", 4, "smallest"));
    // }

    @Test
    public void testKthLargestSingle1() throws IOException {
        createTestFile("test3.txt", "10\n");
        assertEquals(10, ElementFinder.Kth_finder("test3.txt", 1, "largest"));
    }

    @Test
    public void testKthSmallestSingle1() throws IOException {
        createTestFile("test4.txt", "10\n");
        assertEquals(10, ElementFinder.Kth_finder("test4.txt", 1, "smallest"));
    }

    @Test
    public void testKthLargestSingle2() throws IOException {
        createTestFile("test5.txt", "20\n");
        assertEquals(20, ElementFinder.Kth_finder("test5.txt", 1, "largest"));
    }

    @Test
    public void testKthSmallestSingle2() throws IOException {
        createTestFile("test6.txt", "20\n");
        assertEquals(20, ElementFinder.Kth_finder("test6.txt", 1, "smallest"));
    }

    @Test
    public void testKthLargestLarge1() throws IOException {
        createTestFile("test7.txt", "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20\n");
        assertEquals(20, ElementFinder.Kth_finder("test7.txt", 1, "largest"));
    }

    @Test
    public void testKthSmallestLarge1() throws IOException {
        createTestFile("test8.txt", "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20\n");
        assertEquals(1, ElementFinder.Kth_finder("test8.txt", 1, "smallest"));
    }

    @Test
    public void testKthLargestLarge2() throws IOException {
        createTestFile("test9.txt", "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20\n");
        assertEquals(19, ElementFinder.Kth_finder("test9.txt", 2, "largest"));
    }

    @Test
    public void testKthSmallestLarge2() throws IOException {
        createTestFile("test10.txt", "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20\n");
        assertEquals(2, ElementFinder.Kth_finder("test10.txt", 2, "smallest"));
    }
}