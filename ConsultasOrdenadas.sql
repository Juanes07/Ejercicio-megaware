-- Consultar por subcategoria, organizando de manera ascendente por fecha
SELECT scat_id as subcategoria_id,
scat_categoria_id as subcategoria_categoria_id,
scat_nombre as subcategoria_nombre,
scat_created_at as subcategoria_created_at
FROM megaware.subcategoria as subcategoria
ORDER BY subcategoria_created_at ASC;

-- Consultar por subcategoria, organizando  de manera descendente por fecha
SELECT scat_id as subcategoria_id,
scat_categoria_id as subcategoria_categoria_id,
scat_nombre as subcategoria_nombre,
scat_created_at as subcategoria_created_at
FROM megaware.subcategoria as subcategoria
ORDER BY subcategoria_created_at DESC;

-- Consultar por categoria, organizando  de manera ascendente por fecha
SELECT cat_id as categoria_id,
cat_nombre as categoria_nombre,
cat_created_at as categoria_created_at
FROM megaware.categoria as categoria
ORDER BY categoria_created_at ASC;

-- Consultar por categoria, organizando  de manera descendente por fecha 
SELECT cat_id as categoria_id, 
cat_nombre as categoria_nombre, 
cat_created_at as categoria_created_at
FROM megaware.categoria as categoria 
ORDER BY categoria_created_at DESC;

-- consultar por nombre del item, organizado de manera ascendente
SELECT itm_id as item_id,
itm_nombre as item_nombre
FROM megaware.item  
ORDER BY item_nombre ASC;

-- consultar por nombre del item, organizado de manera Descendente
SELECT itm_id as item_id,
itm_nombre as item_nombre
FROM megaware.item  
ORDER BY item_nombre DESC;
