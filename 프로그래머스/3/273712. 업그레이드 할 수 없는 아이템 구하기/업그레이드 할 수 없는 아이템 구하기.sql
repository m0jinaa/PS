select i.item_id, i.item_name, i.rarity
from item_info i
where i.item_id not in (select distinct t.parent_item_id from item_tree t where t.parent_item_id is not null)
order by 1 desc;

