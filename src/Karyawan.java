
public class Karyawan {
	private String kode, nama, gender, jabatan;
	private double gaji;
	
	public Karyawan(String kode, String nama, String gender, String jabatan, double gaji) {
		super();
		this.kode = kode;
		this.nama = nama;
		this.gender = gender;
		this.jabatan = jabatan;
		this.gaji = gaji;
	}
	
	public String getKode() {
		return kode;
	}
	
	public void setKode(String kode) {
		this.kode = kode;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJabatan() {
		return jabatan;
	}
	
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	
	public double getGaji() {
		return gaji;
	}
	
	public void setGaji(double d) {
		this.gaji = d;
	}
}
