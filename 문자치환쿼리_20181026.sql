select concat(',"',replace_a,'"') check_title
 from t_di_keyword_replace_v1 
 where replace_id ='yk_common'
   and keyword_type = 'check_title'
order by keyword_no
;
select concat('urlExceptTitle = urlExceptTitle.replace("',replace_a,'", "',replace_b,'");') check_title
 from t_di_keyword_replace_v1 
 where replace_id ='yk_common'
   and keyword_type = 'title'
order by keyword_no
;
select concat('titleNcontent = titleNcontent.replace("',replace_a,'", "',replace_b,'");') check_title
 from t_di_keyword_replace_v1 
 where replace_id ='yk_common'
   and keyword_type = 'all'
order by keyword_no
;
select concat('titleNcontent = titleNcontent.replace("',replace_a,'", "',replace_b,'");') check_title
 from t_di_keyword_replace_v1 
 where replace_id ='yk_common'
   and keyword_type = 'space'
order by keyword_no
;
select concat('matchTerms = matchTerms.replace( "',replace_a,'", "',replace_b,'");') check_title
 from t_di_keyword_replace_v1 
 where replace_id ='yk_common'
   and keyword_type = 'recovery'
order by keyword_no
;