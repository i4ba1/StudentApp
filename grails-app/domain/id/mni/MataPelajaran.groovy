package id.mni

class MataPelajaran {
    String mapelKode
    String mapelName
    Date createdDate

    static constraints = {
        mapelKode unique: true
        mapelName blank: false, nullable: true
        createdDate: Date
        createdDate(nullable: true)
    }

    static mapping = {

    }
}
