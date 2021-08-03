package wtf.nucker.randomhub.utils;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import wtf.nucker.randomhub.RandomHub;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Nucker
 * @project RandomHub
 * @date 23/07/2021
 */
public class Config {

    private final RandomHub instance = RandomHub.getInstance();

    private Configuration config;
    private final String fileName;

    public Config(String fileName) {
        if (!instance.getDataFolder().exists()) instance.getDataFolder().mkdir();
        File file = new File(instance.getDataFolder(), fileName);
        try {
            if (!file.exists())
                Files.copy(instance.getResourceAsStream(fileName), file.toPath());

            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.fileName = fileName;
    }

    public Configuration getConfig() {
        return config;
    }

    public void save() throws IOException {
        ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(instance.getDataFolder(), fileName));
    }
}
