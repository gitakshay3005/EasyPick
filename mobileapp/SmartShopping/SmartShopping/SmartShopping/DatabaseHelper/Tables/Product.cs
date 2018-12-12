using SQLite;

namespace SmartShopping.DatabaseHelper.Tables
{
    [Table("Product")]
    public class Product
    {
        [PrimaryKey, AutoIncrement, Column("ID")]
        public int ID { get; set; }

        [Column("ProductID")]
        public string ProductID { get; set; }

        [Column("Name")]
        public string Name { get; set; }

        [Column("Quantity")]
        public string Quantity { get; set; }
    }
}
