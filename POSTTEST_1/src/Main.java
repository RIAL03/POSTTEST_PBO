import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Pekerja> daftarPekerja = new ArrayList<>();
    static ArrayList<BlokKebun> daftarBlok = new ArrayList<>();
    static ArrayList<Panen> daftarPanen = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean berjalan = true;

        while (berjalan) {
            clearScreen(); // <--- Membersihkan layar sebelum menu muncul

            System.out.println("=== SISTEM MANAJEMEN KEBUN KELAPA SAWIT ===");
            System.out.println("1. Tambah Data (Create)");
            System.out.println("2. Tampil Data (Read)");
            System.out.println("3. Ubah Data (Update)");
            System.out.println("4. Hapus Data (Delete)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = input.nextInt();
            input.nextLine(); // Membersihkan enter setelah nextInt

            clearScreen(); // <--- Membersihkan layar setelah memilih menu

            switch (pilihan) {
                case 1:
                    tambahData();
                    tekanEnter(); // <--- Menunggu user menekan enter sebelum kembali ke menu
                    break;
                case 2:
                    tampilData();
                    tekanEnter();
                    break;
                case 3:
                    ubahData();
                    tekanEnter();
                    break;
                case 4:
                    hapusData();
                    tekanEnter();
                    break;
                case 5:
                    berjalan = false;
                    System.out.println("Terima kasih telah menggunakan sistem ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    tekanEnter();
            }
        }
    }

    // --- METHOD UNTUK MEMBERSIHKAN LAYAR ---
    static void clearScreen() {
        // Mencetak 50 baris kosong agar teks sebelumnya terdorong ke atas dan hilang
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // --- METHOD UNTUK MENUNGGU USER MENEKAN ENTER ---
    static void tekanEnter() {
        System.out.println("\n[Tekan ENTER untuk kembali ke menu utama...]");
        input.nextLine(); // Program akan berhenti di sini sampai tombol Enter ditekan
    }

    // --- FITUR CREATE ---
    static void tambahData() {
        System.out.println("--- TAMBAH DATA ---");
        System.out.println("1. Pekerja | 2. Blok Kebun | 3. Panen");
        System.out.print("Pilih data yang ingin ditambah: ");
        int jenis = input.nextInt();
        input.nextLine();

        if (jenis == 1) {
            System.out.print("Masukkan ID Pekerja: ");
            String id = input.nextLine();
            System.out.print("Masukkan Nama: ");
            String nama = input.nextLine();
            System.out.print("Masukkan Jabatan (Pemanen/Mandor/dll): ");
            String jabatan = input.nextLine();
            daftarPekerja.add(new Pekerja(id, nama, jabatan));
            System.out.println("=> Data pekerja berhasil ditambahkan!");

        } else if (jenis == 2) {
            System.out.print("Masukkan ID Blok (contoh: B-01): ");
            String id = input.nextLine();
            System.out.print("Masukkan Luas Hektar: ");
            double luas = input.nextDouble();
            System.out.print("Masukkan Jumlah Pohon: ");
            int pohon = input.nextInt();
            daftarBlok.add(new BlokKebun(id, luas, pohon));
            System.out.println("=> Data blok berhasil ditambahkan!");

        } else if (jenis == 3) {
            System.out.print("Masukkan ID Panen: ");
            String id = input.nextLine();
            System.out.print("Masukkan Tanggal (DD-MM-YYYY): ");
            String tgl = input.nextLine();
            System.out.print("Masukkan Hasil Panen (Ton): ");
            double ton = input.nextDouble();
            daftarPanen.add(new Panen(id, tgl, ton));
            System.out.println("=> Data panen berhasil ditambahkan!");
        } else {
            System.out.println("Pilihan salah!");
        }
    }

    // --- FITUR READ ---
    static void tampilData() {
        System.out.println("--- DATA PEKERJA ---");
        if(daftarPekerja.isEmpty()) System.out.println(" Kosong.");
        else for(int i=0; i<daftarPekerja.size(); i++) System.out.println(i + ". " + daftarPekerja.get(i).toString());

        System.out.println("\n--- DATA BLOK KEBUN ---");
        if(daftarBlok.isEmpty()) System.out.println(" Kosong.");
        else for(int i=0; i<daftarBlok.size(); i++) System.out.println(i + ". " + daftarBlok.get(i).toString());

        System.out.println("\n--- DATA PANEN ---");
        if(daftarPanen.isEmpty()) System.out.println(" Kosong.");
        else for(int i=0; i<daftarPanen.size(); i++) System.out.println(i + ". " + daftarPanen.get(i).toString());
    }

    // --- FITUR UPDATE ---
    static void ubahData() {
        System.out.println("--- UBAH DATA ---");
        tampilData();
        System.out.println("\n1. Pekerja | 2. Blok Kebun | 3. Panen");
        System.out.print("Pilih jenis data yang ingin diubah: ");
        int jenis = input.nextInt();
        System.out.print("Masukkan nomor urut (angka paling kiri) yang ingin diubah: ");
        int index = input.nextInt();
        input.nextLine();

        try {
            if (jenis == 1) {
                System.out.print("Masukkan Nama Baru: ");
                String namaBaru = input.nextLine();
                System.out.print("Masukkan Jabatan Baru: ");
                String jabatanBaru = input.nextLine();
                daftarPekerja.get(index).setNama(namaBaru);
                daftarPekerja.get(index).setJabatan(jabatanBaru);
                System.out.println("=> Data berhasil diubah!");
            } else if (jenis == 2) {
                System.out.print("Masukkan Luas Hektar Baru: ");
                double luasBaru = input.nextDouble();
                System.out.print("Masukkan Jumlah Pohon Baru: ");
                int pohonBaru = input.nextInt();
                daftarBlok.get(index).setLuasHektar(luasBaru);
                daftarBlok.get(index).setJumlahPohon(pohonBaru);
                System.out.println("=> Data berhasil diubah!");
            } else if (jenis == 3) {
                System.out.print("Masukkan Hasil Panen (Ton) Baru: ");
                double tonBaru = input.nextDouble();
                daftarPanen.get(index).setTotalTon(tonBaru);
                System.out.println("=> Data berhasil diubah!");
            }
        } catch (Exception e) {
            System.out.println("Error: Nomor tidak ditemukan atau input salah.");
        }
    }

    // --- FITUR DELETE ---
    static void hapusData() {
        System.out.println("--- HAPUS DATA ---");
        tampilData();
        System.out.println("\n1. Pekerja | 2. Blok Kebun | 3. Panen");
        System.out.print("Pilih jenis data yang ingin dihapus: ");
        int jenis = input.nextInt();
        System.out.print("Masukkan nomor urut (angka paling kiri) yang ingin dihapus: ");
        int index = input.nextInt();

        try {
            if (jenis == 1) daftarPekerja.remove(index);
            else if (jenis == 2) daftarBlok.remove(index);
            else if (jenis == 3) daftarPanen.remove(index);
            System.out.println("=> Data berhasil dihapus!");
        } catch (Exception e) {
            System.out.println("Error: Nomor tidak ditemukan.");
        }
    }
}