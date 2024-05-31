package com.github.itdachen.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * PearPageController
 *
 * @author 王大宸
 * @date 2024/4/16 23:46
 */
@Controller
public class PearPageController {
    private static final String PATH_PREFIX = "backstage/pear/view";

    @GetMapping("/view/analysis/index")
    public String viewAnalysisIndex() {
        return PATH_PREFIX + "/analysis/index";
    }

    @GetMapping("/view/console/console1")
    public String viewConsoleConsole1(){
        return PATH_PREFIX + "/console/console1";
    }

    @GetMapping("/view/console/index")
    public String viewConsoleIndex() {
        return PATH_PREFIX + "/console/index";
    }

    @GetMapping("/view/listing/table")
    public String viewListingTable() {
        return PATH_PREFIX + "/listing/table";
    }

}
