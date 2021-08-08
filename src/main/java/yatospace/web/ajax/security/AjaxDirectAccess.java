package yatospace.web.ajax.security;


/**
 * Absolute accepted AJAX access for sessions and 
 * application. 
 * @author MV
 * @version 1.0
 */
public class AjaxDirectAccess extends AjaxAccess{
	
	@Override
	public boolean canAccess() {
		return true;
	}
}
