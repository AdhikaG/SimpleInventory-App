package com.first.utsmcs;

public class Items {

        private String  itemId;
        private String itemName;
        private String itemDescription;
        private String itemQuantity;


        public Items (String itemName, String itemDescription, String itemQuantity ) {

                this.itemName = itemName;
                this.itemDescription = itemDescription;
                this.itemQuantity = itemQuantity;
        }

        public void setItemName(String itemName) {
                this.itemName = itemName;
        }

        public void setItemDescription(String itemDescription) {
                this.itemDescription = itemDescription;
        }

        public void setItemQuantity(String itemQuantity) {
                this.itemQuantity = itemQuantity;
        }

        public String getItemName() {
                return itemName;
        }

        public String getItemDescription() {
                return itemDescription;
        }

        public String getItemQuantity() {
                return itemQuantity;
        }


}


