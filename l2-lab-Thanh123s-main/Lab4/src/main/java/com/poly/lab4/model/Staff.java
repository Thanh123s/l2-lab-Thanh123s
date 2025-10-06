package com.poly.lab4.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String id;
    
    @NotBlank(message = "Họ tên không được để trống")
    private String fullname;
    
    @Builder.Default
    private String photo = "photo.jpg";
    
    @NotNull(message = "Vui lòng chọn giới tính")
    @Builder.Default
    private Boolean gender = true;
    
    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Builder.Default
    private Date birthday = new Date();
    
    @NotNull(message = "Lương không được để trống")
    @Min(value = 1000, message = "Lương phải lớn hơn hoặc bằng 1000")
    @Builder.Default
    private Double salary = 1000.0;
    
    @Min(value = 0, message = "Cấp bậc không hợp lệ")
    @Max(value = 2, message = "Cấp bậc không hợp lệ")
    @Builder.Default
    private Integer level = 0;
}
