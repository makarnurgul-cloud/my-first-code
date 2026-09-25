import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int floors = 3;
        int rooms = 4;
        int hours = 24;

        
        int[][][] co2Data = new int[floors][rooms][hours];
        Random random = new Random();

       
        for (int f = 0; f < floors; f++) {
            for (int r = 0; r < rooms; r++) {
                for (int h = 0; h < hours; h++) {
                    co2Data[f][r][h] = 400 + random.nextInt(1001); // 400..1400
                }
            }
        }

    
        int maxCo2 = -1;
        int maxFloor = 0;
        int maxRoom = 0;
        int maxHour = 0;

        System.out.println("=== 1000 ppm СЫНИ БЕЛГІСІНЕН АСҚАН ОҚИҒАЛАР ТІЗІМІ ===");

        
        for (int f = 0; f < floors; f++) {
            for (int r = 0; r < rooms; r++) {
                for (int h = 0; h < hours; h++) {
                    int currentValue = co2Data[f][r][h];

                    
                    if (currentValue > maxCo2) {
                        maxCo2 = currentValue;
                        maxFloor = f + 1; 
                        
                        maxRoom = r + 1;
                        maxHour = h;
                    }

                   
                    if (currentValue > 1000) {
                        System.out.println("Қабат: " + (f + 1) + 
                                           " | Бөлме: " + (r + 1) + 
                                           " | Сағат: " + h + ":00" + 
                                           " | CO2 деңгейі: " + currentValue + " ppm");
                    }
                }
            }
        }

        System.out.println("\n=== АБСОЛЮТТІ МАКСИМУМ ===");
        System.out.println("Ең жоғары CO2 деңгейі: " + maxCo2 + " ppm");
        System.out.println("Орналасқан жері: " + maxFloor + "-қабат, " + 
                           maxRoom + "-бөлме, сағат " + maxHour + ":00-де тіркелді.");
    }
}