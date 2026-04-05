package utama;

// Import semua class dari folder data
import data.BlokKebun;
import data.Panen;
import data.Pekerja;
import data.Mandor;
import data.Pemanen;
import data.SupirTruk;

// Menggunakan package dari luar modul (Maven)
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Tempat menyimpan data (Database sementara)
    static ArrayList<Pekerja> daftarPekerja = new ArrayList<>();
    static ArrayList<BlokKebun> daftarBlok = new ArrayList<>();
    static ArrayList<Panen> daftarPanen = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean lanjut = true;

        // Looping agar program terus berjalan sampai user memilih Keluar
        while (lanjut) {
            System.out.println("\n=== SISTEM MANAJEMEN KEBUN ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = input.nextInt();
            input.nextLine(); // Membersihkan sisa enter

            if (pilihan == 1) {
                tambahData();
            } else if (pilihan == 2) {
                tampilData();
            } else if (pilihan == 3) {
                ubahData();
            } else if (pilihan == 4) {
                hapusData();
            } else if (pilihan == 5) {
                lanjut = false; // Menghentikan perulangan
                System.out.println("Terima kasih!");
            } else {
                System.out.println("Pilihan salah!");
            }
        }
    }

    // --- FUNGSI UNTUK MENAMBAH DATA (CREATE) ---
    static void tambahData() {
        System.out.println("\n--- TAMBAH DATA ---");
        System.out.println("1. Pekerja | 2. Blok Kebun | 3. Panen");
        System.out.print("Pilih data: ");
        int jenis = input.nextInt();
        input.nextLine();

        if (jenis == 1) { // Jika menambah Pekerja
            System.out.println("Pilih Spesialisasi Pekerja:");
            System.out.println("1. Mandor | 2. Pemanen | 3. Supir Truk");
            System.out.print("Pilihan: ");
            int tipe = input.nextInt();
            input.nextLine();

            System.out.print("Masukkan ID: ");
            String id = input.nextLine();

            System.out.print("Masukkan Nama: ");
            String namaMentah = input.nextLine();

            // Penggunaan Maven: Membuat huruf awal nama menjadi kapital otomatis
            String namaRapi = StringUtils.capitalize(namaMentah);

            // Mengecek tipe pekerja yang dipilih
            if (tipe == 1) {
                System.out.print("Area Tugas: ");
                String area = input.nextLine();
                // Memasukkan subclass Mandor ke dalam daftar Pekerja
                daftarPekerja.add(new Mandor(id, namaRapi, area));
            }
            else if (tipe == 2) {
                System.out.print("Target Harian (Tandan): ");
                int target = input.nextInt();
                daftarPekerja.add(new Pemanen(id, namaRapi, target));
            }
            else if (tipe == 3) {
                System.out.print("Plat Truk: ");
                String plat = input.nextLine();
                daftarPekerja.add(new SupirTruk(id, namaRapi, plat));
            }
            System.out.println("Data pekerja berhasil ditambah!");

        } else if (jenis == 2) { // Jika menambah Blok
            System.out.print("ID Blok: ");
            String id = input.nextLine();
            System.out.print("Luas Hektar: ");
            double luas = input.nextDouble();
            System.out.print("Jumlah Pohon: ");
            int pohon = input.nextInt();

            daftarBlok.add(new BlokKebun(id, luas, pohon));
            System.out.println("Data blok berhasil ditambah!");

        } else if (jenis == 3) { // Jika menambah Panen
            System.out.print("ID Panen: ");
            String id = input.nextLine();
            System.out.print("Tanggal: ");
            String tgl = input.nextLine();
            System.out.print("Total Ton: ");
            double ton = input.nextDouble();

            daftarPanen.add(new Panen(id, tgl, ton));
            System.out.println("Data panen berhasil ditambah!");
        }
    }

    // --- FUNGSI UNTUK MENAMPILKAN DATA (READ) ---
    static void tampilData() {
        System.out.println("\n--- DATA PEKERJA ---");
        if (daftarPekerja.size() == 0) {
            System.out.println("Data kosong.");
        } else {
            for (int i = 0; i < daftarPekerja.size(); i++) {
                // Saat di-print, otomatis memanggil toString() masing-masing subclass
                System.out.println(i + ". " + daftarPekerja.get(i).toString());
            }
        }

        System.out.println("\n--- DATA BLOK KEBUN ---");
        if (daftarBlok.size() == 0) {
            System.out.println("Data kosong.");
        } else {
            for (int i = 0; i < daftarBlok.size(); i++) {
                System.out.println(i + ". " + daftarBlok.get(i).toString());
            }
        }

        System.out.println("\n--- DATA PANEN ---");
        if (daftarPanen.size() == 0) {
            System.out.println("Data kosong.");
        } else {
            for (int i = 0; i < daftarPanen.size(); i++) {
                System.out.println(i + ". " + daftarPanen.get(i).toString());
            }
        }
    }

    // --- FUNGSI UNTUK MENGUBAH DATA (UPDATE) ---
    static void ubahData() {
        tampilData();
        System.out.println("\n1. Pekerja | 2. Blok Kebun | 3. Panen");
        System.out.print("Pilih data yang ingin diubah: ");
        int jenis = input.nextInt();
        System.out.print("Pilih nomor urut data (angka paling kiri): ");
        int index = input.nextInt();
        input.nextLine();

        if (jenis == 1) {

            Pekerja p = daftarPekerja.get(index);

            System.out.print("Nama Baru: ");
            String namaBaru = input.nextLine();
            p.setNama(StringUtils.capitalize(namaBaru));


            if (p instanceof Mandor) {
                System.out.print("Area Tugas Baru: ");
                String areaBaru = input.nextLine();
                // Harus di-ubah ke Mandor dulu (Casting) agar bisa ambil setAreaTugas
                ((Mandor) p).setAreaTugas(areaBaru);
            }
            else if (p instanceof Pemanen) {
                System.out.print("Target Harian Baru: ");
                int targetBaru = input.nextInt();
                ((Pemanen) p).setTargetHarian(targetBaru);
            }
            else if (p instanceof SupirTruk) {
                System.out.print("Plat Truk Baru: ");
                String platBaru = input.nextLine();
                ((SupirTruk) p).setPlatTruk(platBaru);
            }
            System.out.println("Data berhasil diubah!");

        } else if (jenis == 2) {
            System.out.print("Luas Hektar Baru: ");
            double luas = input.nextDouble();
            System.out.print("Jumlah Pohon Baru: ");
            int pohon = input.nextInt();

            daftarBlok.get(index).setLuasHektar(luas);
            daftarBlok.get(index).setJumlahPohon(pohon);
            System.out.println("Data berhasil diubah!");

        } else if (jenis == 3) {
            System.out.print("Total Ton Baru: ");
            double ton = input.nextDouble();

            daftarPanen.get(index).setTotalTon(ton);
            System.out.println("Data berhasil diubah!");
        }
    }

    // FUNGSI UNTUK MENGHAPUS DATA (DELETE)
    static void hapusData() {
        tampilData();
        System.out.println("\n1. Pekerja | 2. Blok Kebun | 3. Panen");
        System.out.print("Pilih data yang ingin dihapus: ");
        int jenis = input.nextInt();
        System.out.print("Pilih nomor urut data: ");
        int index = input.nextInt();

        if (jenis == 1) {
            daftarPekerja.remove(index);
            System.out.println("Data pekerja dihapus.");
        } else if (jenis == 2) {
            daftarBlok.remove(index);
            System.out.println("Data blok dihapus.");
        } else if (jenis == 3) {
            daftarPanen.remove(index);
            System.out.println("Data panen dihapus.");
        }
    }
}