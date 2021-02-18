/*
 * Copyright 2019,2020,2021 yoyosource
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package yapion.datatypes.mc.item;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import yapion.hierarchy.types.YAPIONObject;
import yapion.hierarchy.types.YAPIONType;
import yapion.hierarchy.types.YAPIONValue;
import yapion.serializing.api.SerializerObjectInterface;
import yapion.serializing.data.DeserializeData;
import yapion.serializing.data.SerializeData;

import java.util.Map;

import static yapion.utils.IdentifierUtils.TYPE_IDENTIFIER;

public class ItemStackSerializer implements SerializerObjectInterface<ItemStack> {

    @Override
    public Class<ItemStack> type() {
        return ItemStack.class;
    }

    @Override
    public YAPIONObject serialize(SerializeData<ItemStack> serializeData) {
        YAPIONObject yapionObject = new YAPIONObject();
        yapionObject.add(TYPE_IDENTIFIER, type().getTypeName());
        yapionObject.add("material", serializeData.serialize(serializeData.object.getType()));
        yapionObject.add("amount", new YAPIONValue<>(serializeData.object.getAmount()));
        if (serializeData.object.getItemMeta() != null) {
            Map<String, Object> metaMap = serializeData.object.getItemMeta().serialize();
            yapionObject.add("meta", serializeData.serialize(metaMap));
        }
        return yapionObject;
    }

    @Override
    public ItemStack deserialize(DeserializeData<YAPIONObject> deserializeData) {
        Material material = (Material) deserializeData.deserialize(deserializeData.object.getObject("material"));
        ItemStack itemStack = new ItemStack(material);
        itemStack.setAmount(deserializeData.object.getValue("amount", Integer.class).get());
        if (deserializeData.object.hasValue("meta", YAPIONType.OBJECT)) {
            Map<String, Object> metaMap = (Map<String, Object>) deserializeData.deserialize(deserializeData.object.getObject("meta"));
            itemStack.setItemMeta((ItemMeta) ConfigurationSerialization.deserializeObject(metaMap));
        }
        return itemStack;
    }
}
