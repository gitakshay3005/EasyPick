using SQLite;

namespace SmartShopping.Tables
{
    [Table("Product")]
    public class Product
    {
        [AutoIncrement, Column("ID")]
        public string ID { get; set; }

        [Column("ProductID")]
        public string ProductID { get; set; }

        [Column("Name")]
        public string Name { get; set; }

        [Column("Quantity")]
        public string Quantity { get; set; }
    }
}
