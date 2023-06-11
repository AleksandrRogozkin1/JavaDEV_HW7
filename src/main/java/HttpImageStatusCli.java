import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HttpImageStatusCli {
    public void askStatus(){
        HttpStatusImageDownloader httpStatusImageDownloader=new HttpStatusImageDownloader();
        String statusCode;
        Scanner scanner=new Scanner(System.in);
        String regex = "[0-9]+[\\.]?[0-9]*";

        while (true){
            try {
                System.out.println("Enter HTTP status code: ");
                statusCode=scanner.nextLine();
                if(Pattern.matches(regex,statusCode)){
                    httpStatusImageDownloader.downloadStatusImage(Integer.parseInt(statusCode));
                    System.out.println("Image downloaded.");
                    break;
                }else {
                    System.out.println("Invalid HTTP status code.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

//    public static void main(String[] args) {
//        HttpImageStatusCli httpImageStatusCli=new HttpImageStatusCli();
//        httpImageStatusCli.askStatus();
//    }
}

