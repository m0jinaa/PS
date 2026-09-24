select i.item_id, i.item_name
from item_info i, item_tree t
where i.item_id = t.item_id
and t.parent_item_id is NULL
order by 1;