import java.util.Scanner;

public class Task2_CredentialsManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputInfo = "";
		String input = sc.nextLine();
		Credentials credential = null;
		Credentials[] credentialsArr = new Credentials[200];
		while (!"END".equals(input)) {
			inputInfo = inputInfo + ";" + input;
			input = sc.nextLine();
		}
		String[] splitInputInfo = inputInfo.split(";");

		for (int i = 0; i < splitInputInfo.length; i++) {
			String command = "";
			String userName = "";
			String[] password = new String[100];
			String[] split = splitInputInfo[i].split(" ");
			for (int j=0;j<split.length;j++){
				if (split.length==3){
					if (j==0){
					command = split[j];}
					if (j==1){
					userName = split[j];}
					if (j==2){
					for(int k=0;k<100;k++){
						if (k==0){
							password[k]=split[2];
						}else{
							password[k]=null;
						}
						
					}
					}
					if (command.equals("ENROLL")){
					credential = new Credentials(userName,password);
					credentialsArr[i] = credential;
					
					}/* else 
				if (split.length==4){
					if(command.equals("CHPASS")){
						for (int k = 0;k<200;k++){
							if(credentialsArr[k].userName ==userName){
								System.out.println(credentialsArr[k].changePass(newPassword));
							}							
						}
					}*/
				}
			}
			System.out.println("ENROLL success");
		}
		/*for(int k=0;k<credentialsArr.length;k++){
			if(credentialsArr[k]!=null){
			System.out.println(credentialsArr[k].userName+" @@ "+credentialsArr[k].password);}
				}
*/
	/*	for (int i = 0; i < splitInputInfo.length; i++) {
			String command = "";
			String userName = "";
			String password = "";
			String newPassword = "";
			String[] split = splitInputInfo[i].split(" ");
			for (int j=0;j<split.length;j++){
				if (split.length==3){
					if(j==0){
					command = split[j];}
					if(j==1){
					userName = split[j];}					
					if(j==2){
						password = split[j];						
					}
				}
				for(int k=0;k<credentialsArr.length;k++){
				if (command.equals("AUTH")){
					credentialsArr[i].checkPassword(userName,password);
					
					}
				}
			}
			
		}*/
	}
}
