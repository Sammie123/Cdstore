import java.io.Console;

public class App {
  public static void main(String[] args) {
    Console myConsole = System.console();

    CDStore cdOne = new CDStore("A-ha", "Hunting High and Low", 1985, 10.00);
    CDStore cdTwo = new CDStore("Michael Jackson", "Thriller", 1982, 11.00);
    CDStore cdThree = new CDStore("Soft Cell", "Non-Stop Erotic Cabaret", 1981, 12.00);
    CDStore cdFour = new CDStore("Cyndi Lauper", "She's So Unusual", 1983, 13.00);

    CDStore[] allCD = {cdOne, cdTwo, cdThree, cdFour};

    boolean programRunning = true;

    while(programRunning) {
      System.out.println("What would you like to do?  Please enter one of the following options: See CD list, Search release year, Search price range, Search artist, or Exit");

      String stringAnswer = myConsole.readLine();

      if (stringAnswer.equals("See CD list")) {
        System.out.println("Here's the list of CDs:");
        for(CDStore individualCD: allCD) {
          System.out.println("-------------------------");
          System.out.println(individualCD.mArtistName);
          System.out.println(individualCD.mAlbumName);
          System.out.println(individualCD.mReleaseYear);
          System.out.println(individualCD.mPrice);
        }
      } else if (stringAnswer.equals("Search release year")) {
          System.out.println("Please enter the release year");
          String stringReleaseYear = myConsole.readLine();
          int releaseYear = Integer.parseInt(stringReleaseYear);
          for(CDStore individualCD: allCD) {
            if (releaseYear == individualCD.mReleaseYear) {
              System.out.println("-------------------------");
              System.out.println(individualCD.mArtistName);
              System.out.println(individualCD.mAlbumName);
              System.out.println(individualCD.mReleaseYear);
              System.out.println(individualCD.mPrice);
            }
          }
        } else if (stringAnswer.equals("Search price range")) {
          System.out.println("Please enter your maximum price");
          String stringCDPrice = myConsole.readLine();
          Double price = Double.parseDouble(stringCDPrice);
          for(CDStore individualCD: allCD) {
            if (price > individualCD.mPrice) {
              System.out.println("-----------------------");
              System.out.println(individualCD.mArtistName);
              System.out.println(individualCD.mAlbumName);
              System.out.println(individualCD.mReleaseYear);
              System.out.println(individualCD.mPrice);
            }
          }
        } else if (stringAnswer.equals("Search artist")) {
          System.out.println("Please enter the artist");
          String stringArtist = myConsole.readLine();
          for (CDStore individualCD: allCD) {
            if (individualCD.mArtistName.equals(stringArtist)) {
              System.out.println("-----------");
              System.out.println(individualCD.mArtistName);
              System.out.println(individualCD.mAlbumName);
              System.out.println(individualCD.mReleaseYear);
              System.out.println(individualCD.mPrice);
            }
          }
        } else if (stringAnswer.equals("Exit")) {
            programRunning = false;
        } else {
          System.out.println("Sorry, we don't recognize your input.");
        }
      }
    }
  }
