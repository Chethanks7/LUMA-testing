package framework.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MouseActionUtil {
   private  Actions actions ;

   public void hoverMousePointerToElement(WebElement element){
       actions.moveToElement(element).perform();
   }
}
