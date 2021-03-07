import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	Vector<Karyawan> karyawan = new Vector<>();
	
	public Main() {
//		karyawan.add(new Karyawan("JO-9912","Herman Kuding","Laki-laki","Supervisor",6000000));
//		karyawan.add(new Karyawan("AL-0991","Calvin Nicholas","Laki-laki","Supervisor",6000000));
//		karyawan.add(new Karyawan("GJ-1901","Alicia Gabrielle","Perempuan","Supervisor",6000000));
//		karyawan.add(new Karyawan("ZZ-1123","Felix Jonathan","Laki-laki","Manager",8000000));
		while (true) {
			
			menu();
			sortName();
			System.out.println();
		}
	}
	
	public void sortName() {
		int size = karyawan.size();
		for (int i=0;i<size-1;i++) {
			int done=1;
			for (int j=0;j<size-1;j++) {
				if ((karyawan.get(j).getNama().compareTo(karyawan.get(j+1).getNama()))>0) {
					String tempID = karyawan.get(j).getKode();
					karyawan.get(j).setKode(karyawan.get(j+1).getKode());
					karyawan.get(j+1).setKode(tempID);
					
					String tempNama = karyawan.get(j).getNama();
					karyawan.get(j).setNama(karyawan.get(j+1).getNama());
					karyawan.get(j+1).setNama(tempNama);
					
					
					String tempGender = karyawan.get(j).getGender();
					karyawan.get(j).setGender(karyawan.get(j+1).getGender());
					karyawan.get(j+1).setGender(tempGender);
					
					String tempJabatan = karyawan.get(j).getJabatan();
					karyawan.get(j).setJabatan(karyawan.get(j+1).getJabatan());
					karyawan.get(j+1).setJabatan(tempJabatan);
					
					double tempGaji = karyawan.get(j).getGaji();
					karyawan.get(j).setGaji(karyawan.get(j+1).getGaji());
					karyawan.get(j+1).setGaji(tempGaji);
					
					done = 0;
				}
			}
			if (done==1) {
				break;
			}
		}
	}

	public void menu() {
		System.out.println("Pilih menu: ");
		System.out.println("1. Insert Data Karyawan");
		System.out.println("2. View Data Karyawan");
		System.out.println("3. Update Data Karyawan");
		System.out.println("4. Delete Data Karyawan");
		System.out.println("");
		
		int choose;
		choose = scan.nextInt();
		scan.nextLine();
		System.out.println();
		if (choose == 1) {
			inputData();
		}
		else if (choose == 2) {
			viewData();
		}
		else if (choose == 3) {
			updateData();
		}
		else if (choose == 4) {
			deleteData();
		}
//		else {
//			StringBuilder tempID = new StringBuilder(7);
//			
//			String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//			StringBuilder tempIDCode = new StringBuilder(2);
//			for (int i=0;i<2;i++) {
//				int index = (int)(26 * Math.random());
//				tempIDCode.append(Alphabet.charAt(index));
//			}
//			
//			int tempIDNum = (int)(Math.random() * (9000) + 1000);
//			
//			tempID.append(tempIDCode + "-" + tempIDNum);
//			System.out.println(tempID);
//		}
	}
	
	public void inputData() {
		
		/*ID*/
		StringBuilder sb = new StringBuilder(7);
		
		String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder tempIDCode = new StringBuilder(2);
		for (int i=0;i<2;i++) {
			int index = (int)(26 * Math.random());
			sb.append(Alphabet.charAt(index));
		}
		
		int tempIDNum = (int)(Math.random() * (9000) + 1000);
		
		sb.append(tempIDCode + "-" + tempIDNum);
		String tempID = sb.toString();
		
		/*Nama*/
		String tempNama = "";
		while (tempNama.length()<3) {
			System.out.printf("Input nama karyawan [>= 3]: ");
			tempNama = scan.nextLine();
		}
		
		/*Jenis Kelamin*/
		String tempGender = "";
		while (true) {
			System.out.printf("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			tempGender = scan.nextLine();
			if (tempGender.equals("Laki-laki") || tempGender.equals("Perempuan")) {
				break;
			}
		}
		
		/*Jabatan*/
		String tempJabatan = "";
		while (true) {
			System.out.printf("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			tempJabatan = scan.nextLine();
			if (tempJabatan.equals("Manager") || tempJabatan.equals("Supervisor") || tempJabatan.equals("Admin")) {
				break;
			}
		}
		
		/*Gaji*/
		double tempGaji = 0;
		if (tempJabatan.equals("Manager")) {
			tempGaji = 8000000;
		}
		else if (tempJabatan.equals("Supervisor")) {
			tempGaji = 6000000;
		}
		else if (tempJabatan.equals("Admin")) {
			tempGaji = 4000000;
		}

		System.out.println("Berhasil menambahkan karyawan dengan id " + tempID);
		
		/*Bonus*/
		int count=0;
		Vector<String> listID = new Vector<>();
		int size = karyawan.size();
		for (int i=0;i<size-1;i++) {
			if (karyawan.get(i).getJabatan().compareTo(tempJabatan)==0) {
				count++;
			}
		}
		
		if (count>=3) {
			for (int i=0;i<size;i++) {
				if (karyawan.get(i).getJabatan().compareTo(tempJabatan)==0) {
					listID.add(karyawan.get(i).getKode());
					if(tempJabatan.compareTo("Manager")==0) {
						double tempBonus = karyawan.get(i).getGaji() * 0.1;
						karyawan.get(i).setGaji(karyawan.get(i).getGaji() + tempBonus);
					}
					else if(tempJabatan.compareTo("Supervisor")==0) {
						double tempBonus = karyawan.get(i).getGaji() * 0.075;
						karyawan.get(i).setGaji(karyawan.get(i).getGaji() + tempBonus);
					}
					else if(tempJabatan.compareTo("Admin")==0) {
						double tempBonus = karyawan.get(i).getGaji() * 0.05;
						karyawan.get(i).setGaji(karyawan.get(i).getGaji() + tempBonus);
					}
				}
			}
			
			String tipeBonus="";
			if(tempJabatan.compareTo("Manager")==0) {
				tipeBonus = "10%";
			}
			else if(tempJabatan.compareTo("Supervisor")==0) {
				tipeBonus = "7.5%";
			}
			else if(tempJabatan.compareTo("Admin")==0) {
				tipeBonus = "5%";
			}
			System.out.print("Bonus sebesar " + tipeBonus + " telah diberikan kepada karyawan dengan id");
			
			int sizeBonus = listID.size();
			for (int i=0;i<sizeBonus;i++) {
				if (i==sizeBonus-1) {
					System.out.printf(" %s\n",listID.get(i));
				}
				else {
					System.out.printf(" %s,",listID.get(i));
				}
			}
		}
		
		karyawan.add(new Karyawan(tempID,tempNama,tempGender,tempJabatan,tempGaji));
		System.out.println("ENTER to return");
		scan.nextLine();
	}
	
	public void viewData() {
		
		
		int size = karyawan.size();

		System.out.println("|----|-----------------|------------------------------|---------------|---------------|---------------|");
		System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan        |Gaji Karyawan  |");
		System.out.println("|----|-----------------|------------------------------|---------------|---------------|---------------|");
		for (int i=0;i<size;i++) {
			long tempGaji = (long)karyawan.get(i).getGaji();
			System.out.printf("|%4d|%17s|%30s|%15s|%15s|%15d|\n",i+1,karyawan.get(i).getKode(),karyawan.get(i).getNama(),karyawan.get(i).getGender(),karyawan.get(i).getJabatan(),tempGaji);
		}
		System.out.println("|----|-----------------|------------------------------|---------------|---------------|---------------|");
	}
	
	public void updateData() {
		viewData();
		
		System.out.print("Masukkan nomor angka dari list yang ingin diupdate : ");
		int num;
		num = scan.nextInt();
		scan.nextLine();
		
		if (num<=karyawan.size()) {
			/*ID*/
			StringBuilder sb = new StringBuilder(7);
			
			String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			StringBuilder tempIDCode = new StringBuilder(2);
			for (int i=0;i<2;i++) {
				int index = (int)(26 * Math.random());
				sb.append(Alphabet.charAt(index));
			}
			
			int tempIDNum = (int)(Math.random() * (9000) + 1000);
			
			sb.append(tempIDCode + "-" + tempIDNum);
			String tempID = sb.toString();
			
			/*Nama*/
			String tempNama = "";
			while (tempNama.length()<3) {
				System.out.printf("Input nama karyawan [>= 3]: ");
				tempNama = scan.nextLine();
			}
			
			/*Jenis Kelamin*/
			String tempGender = "";
			while (true) {
				System.out.printf("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
				tempGender = scan.nextLine();
				if (tempGender.equals("Laki-laki") || tempGender.equals("Perempuan")) {
					break;
				}
			}
			
			/*Jabatan*/
			String tempJabatan = "";
			while (true) {
				System.out.printf("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
				tempJabatan = scan.nextLine();
				if (tempJabatan.equals("Manager") || tempJabatan.equals("Supervisor") || tempJabatan.equals("Admin")) {
					break;
				}
			}
			
			/*Gaji*/
			double tempGaji = 0;
			if (tempJabatan.equals("Manager")) {
				tempGaji = 8000000;
			}
			else if (tempJabatan.equals("Supervisor")) {
				tempGaji = 6000000;
			}
			else if (tempJabatan.equals("Admin")) {
				tempGaji = 4000000;
			}
			
			karyawan.get(num-1).setKode(tempID);
			karyawan.get(num-1).setNama(tempNama);
			karyawan.get(num-1).setGender(tempGender);
			karyawan.get(num-1).setJabatan(tempJabatan);
			karyawan.get(num-1).setGaji(tempGaji);
			
			System.out.println("Update data berhasil");
		}
		else {
			System.out.println("Update data gagal");
		}
		
		System.out.println("ENTER to return");
		scan.nextLine();
	}
		
	
	public void deleteData() {
		viewData();
		
		System.out.print("Masukkan nomor angka dari list yang ingin dihapus : ");
		int num;
		num = scan.nextInt();
		scan.nextLine();
		
		if (num<=karyawan.size()) {
			karyawan.remove(num-1);
			System.out.println("Hapus data berhasil");
		}
		else {
			System.out.println("Hapus data gagal");
		}
		
		System.out.println("ENTER to return");
		scan.nextLine();
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
