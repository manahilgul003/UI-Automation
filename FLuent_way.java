public String getNestedText() {
	 WebElement nestedText = getDriver ().findElement (By.id ("shadow_host"))
		 .getShadowRoot ()
		 .findElement (By.cssSelector ("#nested_shadow_host"))
		 .getShadowRoot ()
		 .findElement (By.cssSelector ("#nested_shadow_content > div"));
	 return nestedText.getText ();
	}
