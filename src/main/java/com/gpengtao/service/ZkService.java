package com.gpengtao.service;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.gpengtao.web.vo.ZkViewModel;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by gpengtao on 15/10/11.
 */
@Service
public class ZkService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${zkAddress}")
    private String zkAddress;

    private ZooKeeper zooKeeper;

    public ZkViewModel view(String path) throws Exception {

        Map<String, String> childPathMap = getChildNameAndPathMap(path);

        String data;
        byte[] dataByte = zooKeeper.getData(path, false, null);
        if (dataByte == null) {
            data = "null";
        } else {
            data = new String(dataByte);
        }

        String parentPath = getParentPath(path);

        ZkViewModel model = new ZkViewModel();
        model.setPath(path);
        model.setData(data);
        model.setParentPath(parentPath);
        model.setChildrenPath(childPathMap);
        return model;
    }

    private static String getParentPath(String path) {
        if (Objects.equal("/", path)) {
            return path;
        }
        int last = path.lastIndexOf("/");
        return path.substring(0, last);
    }

    private Map<String, String> getChildNameAndPathMap(String path) throws Exception {
        List<String> children = zooKeeper.getChildren(path, false);
        Map<String, String> childPathMap = Maps.newLinkedHashMap();
        for (String one : children) {
            if (!path.endsWith("/")) {
                path += "/";
            }
            childPathMap.put(one, path + one);
        }
        return childPathMap;
    }

    public String getZkAddress() {
        return zkAddress;
    }

    @PostConstruct
    public void initZK() throws IOException {
        zooKeeper = new ZooKeeper(zkAddress, 1000, new Watcher() {
            public void process(WatchedEvent event) {

            }
        });
        logger.info("初始化zk完成：{}", zooKeeper);
    }

}
