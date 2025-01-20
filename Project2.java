import java.util.Scanner;

public class Project2 {
    static class Video {
        private String title;
        private boolean checkedOut;
        private double averageRating;
        private int ratingCount;
        private int totalRating;

        public Video(String title) {
            this.title = title;
            this.checkedOut = false;
            this.averageRating = 0.0;
            this.ratingCount = 0;
            this.totalRating = 0;
        }

        public String getTitle() {
            return title;
        }

        public boolean isCheckedOut() {
            return checkedOut;
        }

        public void checkOut() {
            checkedOut = true;
        }

        public void returnVideo() {
            checkedOut = false;
        }

        public void receiveRating(int rating) {
            totalRating += rating;
            ratingCount++;
            averageRating = (double) totalRating / ratingCount;
        }

        public double getAverageRating() {
            return averageRating;
        }
    }

    static class VideoStore {
        private Video[] inventory;
        private int count;

        public VideoStore() {
            inventory = new Video[10];
            count = 0;
        }

        public void addVideo(String title) {
            if (count < inventory.length) {
                inventory[count] = new Video(title);
                count++;
            }
            System.out.print("Video Added Successfully ");
        }

        public void checkOut(String title) {
            for (int i = 0; i < count; i++) {
                if (inventory[i].getTitle().equals(title) && !inventory[i].isCheckedOut()) {
                    inventory[i].checkOut();
                    break;
                }
            }
            System.out.print("Video Checked Out Successfully ");
        }

        public void returnVideo(String title) {
            for (int i = 0; i < count; i++) {
                if (inventory[i].getTitle().equals(title) && inventory[i].isCheckedOut()) {
                    inventory[i].returnVideo();
                    break;
                }
            }
            System.out.print("Video returned Successfully ");
        }

        public void receiveRating(String title, int rating) {
            for (int i = 0; i < count; i++) {
                if (inventory[i].getTitle().equals(title)) {
                    inventory[i].receiveRating(rating);
                    break;
                }
            }
            System.out.print("Rating Added Successfully ");
        }

        public void listInventory() {
            for (int i = 0; i < count; i++) {
                System.out.println("Title: " + inventory[i].getTitle() + ", Checked Out: " + inventory[i].isCheckedOut() + ", Average Rating: " + inventory[i].getAverageRating());
            }
        }
    }

    
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);


            VideoStore store = new VideoStore();
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Video");
            System.out.println("2. Check Out Video");
            System.out.println("3. Return Video");
            System.out.println("4. Receive Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. List Checked Out Videos");
            System.out.println("7. Go Back");
            System.out.println("8. Exit");

            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter video title: ");
                    String title = input.nextLine();
                    store.addVideo(title);
                    break;
                case 2:
                    System.out.print("Enter video title to check out: ");
                    title = input.nextLine();
                    store.checkOut(title);
                    break;
                case 3:
                    System.out.print("Enter video title to return: ");
                    title = input.nextLine();
                    store.returnVideo(title);
                    break;
                case 4:
                    System.out.print("Enter video title to rate: ");
                    title = input.nextLine();
                    System.out.print("Enter rating (1-5): ");
                    int rating = input.nextInt();
                    store.receiveRating(title, rating);
                    break;
                case 5:
                    store.listInventory();
                    break;
                case 6:
                    for (int i = 0; i < store.inventory.length; i++) {
                        if (store.inventory[i] != null && store.inventory[i].isCheckedOut()) {
                            System.out.println("Title: " + store.inventory[i].getTitle() + ", Average Rating: " + store.inventory[i].getAverageRating());
                        }
                    }
                    break;
                case 7:
                    continue;
                case 8:
                    System.out.println("Exiting...");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        }
    
}
