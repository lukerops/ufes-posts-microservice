@Repository
interface MediaRepository: CrudRepository<Media, Long>{

    fun findByMediaId(mediaId: Long): List<Media>

}

