package music_management.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private int id;

    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được nhập ký tự trắng đầu tiên")
    @Size(max = 800)
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Ll}][\\p{Ll}]{1,10}))*$", message = "Sai định dạng tên vài hát, vui lòng viết Hoa chữ cái đầu")
    private String musicName;

    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được nhập ký tự trắng đầu tiên")
    @Size(max = 300)
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Ll}][\\p{Ll}]{1,10}))*$", message = "Sai định dạng tên ca sỹ, vui lòng viết Hoa chữ cái đầu !")
    private String singerName;

    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được nhập ký tự trắng đầu tiên")
    @Size(max = 1000)
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll},]{1,8})(\\s([\\p{Lu}]|[\\p{Ll}][\\p{Ll},]{1,10}))*$", message = "Sai định dạng thể loại nhạc, vui lòng viết hoa chữ cái đầu !")
    private String kindOfMusic;

    public MusicDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        if (musicDto.musicName.equals("admin")) {
            errors.rejectValue("musicName", "", "Không được nhập tên bài hát là: admin");
        }
    }
}
