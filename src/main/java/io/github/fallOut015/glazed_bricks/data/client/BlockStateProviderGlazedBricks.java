package io.github.fallOut015.glazed_bricks.data.client;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import io.github.fallOut015.glazed_bricks.world.level.block.BlocksGlazedBricks;
import net.minecraft.client.renderer.block.model.BlockModelDefinition;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.fmllegacy.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BlockStateProviderGlazedBricks extends BlockStateProvider {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    private final DataGenerator gen;

    public BlockStateProviderGlazedBricks(DataGenerator gen) {
        super(gen);
        this.gen = gen;
    }

    public void registerStatesAndModels() {
        Path path = this.gen.getOutputFolder();
        Map<Block, IFinishedBlockState> map = Maps.newHashMap();

        List<RegistryObject<Block>> list = BlocksGlazedBricks.getEntries().stream().filter(block -> !map.containsKey(block.get())).collect(Collectors.toList());

        list.forEach(block -> {
            if(block.get() instanceof FlowerPotBlock) {
                BlockModelDefinition model = new BlockModelDefinition().with(BlockModelFields.MODEL, new ResourceLocation(Objects.requireNonNull(block.get().getRegistryName()).getNamespace() + ":block/" + Objects.requireNonNull(block.get().getRegistryName()).getPath()));
                map.put(block.get(), FinishedVariantBlockState.multiVariant(block.get(), model));
            }
        });

        this.write(cache, path, map, BlockStateProviderGlazedBricks::blockStateResolver);
    }

    private <T> void write(HashCache cache, Path path1, Map<T, ? extends Supplier<JsonElement>> files, BiFunction<Path, T, Path> pathGetter) {
        files.forEach((key, file) -> {
            Path path = pathGetter.apply(path1, key);

            try {
                IDataProvider.save(GSON, cache, file.get(), path);
            } catch (Exception exception) {
                LOGGER.error("Couldn't save {}", path, exception);
            }
        });
    }

    private static Path blockStateResolver(Path p_240082_0_, Block p_240082_1_) {
        ResourceLocation resourcelocation = Registry.BLOCK.getKey(p_240082_1_);
        return p_240082_0_.resolve("assets/" + resourcelocation.getNamespace() + "/blockstates/" + resourcelocation.getPath() + ".json");
    }
}