-- This migration fixes the table name case for the categories schema.
-- It renames the existing uppercase table CATEGORIAS to lowercase categorias when needed.

SET @exists_uc = (SELECT COUNT(*) FROM information_schema.TABLES
                   WHERE TABLE_SCHEMA = DATABASE()
                     AND TABLE_NAME = 'CATEGORIAS');

SET @exists_lc = (SELECT COUNT(*) FROM information_schema.TABLES
                   WHERE TABLE_SCHEMA = DATABASE()
                     AND TABLE_NAME = 'categorias');

SET @sql = IF(@exists_uc > 0 AND @exists_lc = 0,
              'ALTER TABLE CATEGORIAS RENAME TO categorias;',
              'SELECT 1;');

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
