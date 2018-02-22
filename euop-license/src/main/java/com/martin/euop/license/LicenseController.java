package com.martin.euop.license;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2/22/18 11:16 AM
 * Descrition
 */
@RestController
public class LicenseController {
    @RequestMapping(value = "/licenseInfo",method = RequestMethod.GET)
    public String getLicenseInfo(){
        return "licenseInfo";
    }
}
