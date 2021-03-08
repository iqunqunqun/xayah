package com.ivan.xayah.init;

import com.ivan.xayah.service.ISysDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author ivan
 * @className DictInit
 * @since 2021/3/7 20:52
 */

@Component
@Slf4j
public class DictInit implements CommandLineRunner {

    @Autowired
    private ISysDictService dictService;

    @Override
    public void run(String... args) throws Exception {
        log.info("===================字典初始化至内存===================");
        dictService.init();
    }
}
