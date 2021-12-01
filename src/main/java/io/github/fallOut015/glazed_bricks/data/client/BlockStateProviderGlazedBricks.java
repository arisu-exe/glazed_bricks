package io.github.fallOut015.glazed_bricks.data.client;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import io.github.fallOut015.glazed_bricks.world.level.block.BlocksGlazedBricks;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.block.model.BlockModelDefinition;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.BlockModelConfiguration;
import net.minecraftforge.client.model.ModelDataManager;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.IGeneratedBlockstate;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
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

    public BlockStateProviderGlazedBricks(DataGenerator gen, ExistingFileHelper existingFileHelper) {
        super(gen, MainGlazedBricks.MODID, existingFileHelper);
        this.gen = gen;
    }

    public void registerStatesAndModels() {
        Path path = this.gen.getOutputFolder();

        Map<Block, IGeneratedBlockstate> map = Maps.newHashMap();

        List<RegistryObject<Block>> list = BlocksGlazedBricks.getEntries().stream().filter(block -> !map.containsKey(block.get())).collect(Collectors.toList());

        list.forEach(block -> {
            if(block.get() instanceof FlowerPotBlock) {
                map.put(block.get(), this.getVariantBuilder(block.get()).setModels(null));
                // TODO
                //BlockModelDefinition model = new BlockModelDefinition().with(BlockModelFields.MODEL, new ResourceLocation(Objects.requireNonNull(block.get().getRegistryName()).getNamespace() + ":block/" + Objects.requireNonNull(block.get().getRegistryName()).getPath()));
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