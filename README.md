# Movie Review
This repo is created for Dicoding online class named "Menjadi Android Developer Expert".

## Submission 1
### Daftar Film
* Menggunakan ListView untuk menampilkan daftar film dengan jumlah minimal 10 item.

### Detail Film
* Menampilkan poster dan informasi film pada halaman detail film.
* Menggunakan Parcelable sebagai interface dari obyek data yang akan dikirimkan antar Activity.
---

## Submission 2
### Daftar Film
* Terdapat 2 (dua) halaman yang menampilkan daftar film (**Movies** dan **Tv Show**).
* Menggunakan **Fragment** untuk menampung halaman **Movies** dan **Tv Show**.
* Menggunakan **RecyclerView** untuk menampilkan daftar film dengan jumlah **minimal 10 item**.
* Menggunakan **TabLayout**, **BottomNavigationView**, atau yang lainnya sebagai navigasi antara halaman **Movies** dan **Tv Show**.

### Detail Film 
* Menampilkan poster dan informasi film pada halaman detail film.
* Menggunakan **Parcelable** sebagai interfaces dari obyek yang akan dikirimkan antar **Activity** atau **Fragment**.
* Menggunakan **ConstraintLayout** untuk menyusun layout.

### Localization
* Aplikasi harus mendukung bahasa Indonesia dan bahasa Inggris.
---

## Submission 3
### Daftar film
* Terdapat 2 (dua) halaman yang menampilkan daftar film (Movies dan Tv Show)
* Menggunakan Fragment untuk menampung halaman Movies dan Tv Show.
* Menggunakan RecyclerView untuk menampilkan daftar film.
* Menggunakan TabLayout, BottomNavigationView atau yang lainnya sebagai navigasi antara halaman Movies dan Tv Show.
* Menampilkan indikator loading ketika data sedang dimuat.

### Detail film
* Menampilkan poster dan informasi film pada halaman detail film.
* Menggunakan ConstraintLayout untuk menyusun layout.
* Menampilkan indikator loading ketika data sedang dimuat.

### Localization
* Aplikasi harus mendukung bahasa Indonesia dan bahasa Inggris.

### Configuration Changes
* Aplikasi harus bisa menjaga data yang sudah dimuat ketika terjadi pergantian orientasi dari potrait ke landscape atau sebaliknya.
---

## Submission 4
### Daftar film
* Terdapat 2 (dua) halaman yang menampilkan daftar film (Movies dan Tv Show).
* Menggunakan Fragment untuk menampung halaman Movies dan Tv Show.
* Menggunakan RecyclerView untuk menampilkan daftar film.
* Menggunakan BottomNavigationView, TabLayout, atau yang lainnya sebagai navigasi antara halaman Movies dan Tv Show.
* Menampilkan indikator loading ketika data sedang dimuat.

### Detail film
* Menampilkan poster dan informasi film pada halaman detail film.
* Menggunakan ConstraintLayout untuk menyusun layout.
* Menampilkan indikator loading ketika data sedang dimuat.

### Favorite Film
* Dapat menyimpan film ke database favorite.
* Dapat menghapus film dari database favorite.
* Terdapat halaman untuk menampilkan daftar Favorite Movies.
* Terdapat halaman untuk menampilkan daftar Favorite Tv Show.

### Localization
* Aplikasi harus mendukung bahasa Indonesia dan bahasa Inggris.

### Configuration Changes
* Aplikasi harus bisa menjaga data yang sudah dimuat ketika terjadi pergantian orientasi dari potrait ke landscape atau sebaliknya.
---

## Final Project
### Pencarian film
* Pengguna dapat melakukan pencarian Movies.
* Pengguna dapat melakukan pencarian Tv Show.

### Widget
* Pengguna dapat menampilkan widget dari film favorite ke halaman utama smartphone.
* Tipe widget yang diterapkan adalah Stack Widget.

### Reminder
* Daily Reminder, mengirimkan notifikasi ke pengguna untuk kembali ke Aplikasi Movie Catalogue. Daily reminder harus selalu berjalan tiap jam 7 pagi.
* Release Today Reminder, mengirimkan notifikasi ke pengguna semua film yang rilis hari ini dengan menggunakan Stack Notification dengan Inbox Style (wajib menggunakan endpoint seperti yang telah disediakan pada bagian Resources di bawah). Release reminder harus selalu berjalan tiap jam 8 pagi.
* Terdapat halaman pengaturan untuk mengaktifkan dan menonaktifkan reminder.

### Aplikasi Favorite
* Membuat aplikasi atau modul baru yang menampilkan daftar film favorite.
* Menggunakan Content Provider sebagai mekanisme untuk mengakses data dari satu aplikasi ke aplikasi lain.

