package id.mni



interface MataPelajaranService {
    MataPelajaran getMapelById(UUID id)
    List<MataPelajaran> getAllMapel();
    MataPelajaran save(MataPelajaran mapel)
    void delete(UUID uuid)
}
