package id.mni

import grails.transaction.Transactional
import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class  MataPelajaranController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", list:"GET"]

    def index(Integer max){
        params.max = Math.min(max ?: 10, 100)
        respond MataPelajaran.list()
    }

    def create = {

    }

    /**
     * Save mapel to database
     * @param mapel
     * @return
     */
    @Transactional
    def save(MataPelajaran mapel) {
        if (mapel == null) {
            notFound()
            return
        }

        if (mapel.hasErrors()) {
            respond mapel.errors, view:'create'
            return
        }

        def m = new MataPelajaran(mapelKode: mapel.getMapelKode(), mapelName: mapel.getMapelName(), createdDate: new Date())
        m.save(flush:true)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message',
                        args: [message(code: 'feedback.label',
                                default: 'Feedback'), m.id])
                redirect m
            }
            '*' { respond m, [status: OK] }
        }
    }

    def edit = {
        def m = MataPelajaran.get(params.id)
        respond(mataPelajaran:m)
    }

    /**
     * Update Mata Pelajaran
     * @param mapel
     * @return
     */
    @Transactional
    def update(MataPelajaran mapel){
        if (mapel == null) {
            notFound()
            return
        }

        if (mapel.hasErrors()) {
            respond mapel.errors, view:'edit'
            return
        }

        def currentMapel = MataPelajaran.find(mapel)
        currentMapel.setMapelName(mapel.getMapelName())
        currentMapel.save(flush:true)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message',
                        args: [message(code: 'feedback.label',
                                default: 'Feedback'), currentMapel.id])
                redirect currentMapel
            }
            '*' { respond currentMapel, [status: OK] }
        }
    }

    def show(Long id) {
        def m = MataPelajaran.get(id)
        [mataPelajaran: m]
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MataPelajaran.list()
    }

    /**
     * Delete Mata Pelajaran
     * @param mataPelajaran
     * @return
     */
    @Transactional
    def delete(MataPelajaran mataPelajaran) {
        if (mataPelajaran == null) {
            notFound()
            return
        }

        mataPelajaran.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message',
                        args: [message(code: 'Feedback.label', default: 'Feedback'),
                               mataPelajaran.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'feedback.label', default: 'Feedback'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
